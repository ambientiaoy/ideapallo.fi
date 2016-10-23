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
        .module('webApp')
        .directive('facebookSignInForm', function() {
            return {
                restrict: 'E',
                scope: {},
                templateUrl: 'src/app/components/forms/facebookSignInForm.html',
                controller: 'FacebookSignInFormController'
            };
        });

    angular
        .module('webApp')
        .controller('FacebookSignInFormController', FacebookSignInFormController);

    FacebookSignInFormController.$inject = ['$scope', '$state', 'eventBus', 'authenticationApi', '$auth', 'sessionService'];

    function FacebookSignInFormController($scope, $state, eventBus, authenticationApi, $auth, sessionService) {

        $scope.model = {};
        $scope.errorCode = null;
        $scope.submit = submit;

        $scope.signIn = signIn;

        function signIn() {
            $auth.authenticate('facebook')
                .then(function(response) {
                    $scope.model.facebookAccessToken = response.access_token;
                    submit();
                })
                .catch(function(response) {
                    console.log('User cancelled login or did not fully authorize.');
                });
        }

        function submit(form) {
            if (form !== undefined && form.$submitted && form.$invalid) {
                return false;
            }
            authenticationApi.facebookSignIn($scope.model).then(onSuccess, onError);

            function onSuccess(response) {

                sessionService.save(response.data);
                eventBus.emitEvent('UserSignedIn', {
                    accessToken: response.data.accessToken,
                    id: response.data.id,
                    username: response.data.username,
                    role: response.data.role,
                    email: response.data.email
                });
                $state.go('ideasPage');
                $scope.errorCode = null;
            }

            function onError(response) {
                if (response.status == 302) {
                    eventBus.emitEvent('FacebookSignUp', {
                        facebookAccessToken: $scope.model.facebookAccessToken
                    });
                } else if (response.status && response.statusText) {
                    $scope.errorCode = response.statusText;
                } else {
                    $scope.errorCode = 'Unknown error';
                }
            }

        }

    }

})();