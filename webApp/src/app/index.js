/**
 * Copyright 2016 dryTools doo
 * Email: contact@drytools.co
 * 
 * This file is part of ideapallo.
 * 
 * ideapallo is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * ideapallo is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with ideapallo. If not, see <http://www.gnu.org/licenses/>.*
 **/
(function() {
    'use strict';

    angular
        .module('webApp', ['ngAnimate', 'ngCookies', 'ngTouch', 'ngSanitize', 'ui.router', 'satellizer',
            'ui.bootstrap', 'ngMessages', 'pascalprecht.translate', 'app.config'
        ])
        .config(appConfig)
        .config(facebookApiConfig)
        .run(run);

    appConfig.$inject = ['$stateProvider', '$urlRouterProvider'];

    function appConfig($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('appPage', {
                url: '/home',
                templateUrl: 'src/app/components/pages/appPage.html',
                controller: 'AppPageController'
            })
            .state('appPage.homePage', {
                url: '/home',
                templateUrl: 'src/app/components/pages/homePage.html',
                controller: 'HomePageController'
            })
            .state('appPage.ideasPage', {
                url: '/ideas',
                templateUrl: 'src/app/components/pages/ideasPage.html',
                controller: 'IdeasPageController'
            })
            .state('ideaPage', {
                url: '/home/idea/{id}',
                templateUrl: 'src/app/components/pages/ideaPage.html',
                controller: 'IdeaPageController'
            })
            .state('findByTags', {
                url: '/home/tags',
                templateUrl: 'src/app/components/pages/findByTags.html',
                controller: 'FindByTagsController'
            })
            .state('signInPage', {
                url: '/home/sign-in',
                templateUrl: 'src/app/components/pages/signInPage.html',
                controller: 'SignInPageController'
            })
            .state('signUpPage', {
                url: '/home/sign-up',
                templateUrl: 'src/app/components/pages/signUpPage.html',
                controller: 'SignUpPageController'
            })
            .state('verifyEmailPage', {
                url: '/home/verify-email/{emailVerificationCode}',
                templateUrl: 'src/app/components/pages/verifyEmailPage.html',
                controller: 'VerifyEmailPageController'
            })
            .state('forgotPasswordPage', {
                url: '/home/forgot-password',
                templateUrl: 'src/app/components/pages/forgotPasswordPage.html',
                controller: 'ForgotPasswordPageController'
            })
            .state('resetPasswordPage', {
                url: '/home/reset-password/{resetPasswordCode}',
                templateUrl: 'src/app/components/pages/resetPasswordPage.html',
                controller: 'ResetPasswordPageController'
            });

        $urlRouterProvider.otherwise('/home/home');
    }

    facebookApiConfig.$inject = ['$authProvider', 'clientConfigurationValues'];

    function facebookApiConfig($authProvider, clientConfigurationValues) {
        $authProvider.withCredentials = false;
        $authProvider.tokenName = 'token';
        $authProvider.tokenPrefix = 'facebook';

        $authProvider.httpInterceptor = function() {
            return false;
        }

        $authProvider.oauth2({
            name: 'facebook',
            clientId: clientConfigurationValues.facebookAppId,
            redirectUri: window.location.origin || window.location.protocol + '//' + window.location.host + '/',
            authorizationEndpoint: 'https://www.facebook.com/v2.5/dialog/oauth',
            scope: ['public_profile'],
            scopeDelimiter: ',',
            display: 'popup',
            type: '2.0',
            popupOptions: {
                width: 580,
                height: 400
            },
            responseType: 'token'
        });
    }

    run.$inject = ['$rootScope', '$state', 'sessionService', '$log'];

    function run($rootScope, $state, sessionService, $log) {
        $rootScope.$on('$stateChangeStart', function(ev, to) {
            if (to.name === 'signInPage') {
                sessionService.clear();
            } else if (!sessionService.canUserAccessState(to.name)) {
                $log.warn('Unauthorized access to secured page, redirecting to signIn.');
                ev.preventDefault();
                $state.go('signInPage');
            }
            $rootScope.pageTitle = to.title;
        });
    }

})();