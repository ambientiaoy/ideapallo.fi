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
        .directive('emailSignInForm', function() {
            return {
                restrict: 'E',
                scope: {},
                templateUrl: 'src/app/components/forms/emailSignInForm.html',
                controller: 'EmailSignInFormController'
            };
        });

    angular
        .module('webApp')
        .controller('EmailSignInFormController', EmailSignInFormController);

    EmailSignInFormController.$inject = ['$scope', '$state', 'eventBus', 'authenticationApi', 'sessionService'];

    function EmailSignInFormController($scope, $state, eventBus, authenticationApi, sessionService) {

        $scope.model = {};
        $scope.errorCode = null;
        $scope.submit = submit;

        function submit(form) {
            if (form !== undefined && form.$submitted && form.$invalid) {
                return false;
            }
            authenticationApi.emailSignIn($scope.model).then(onSuccess, onError);

            function onSuccess(response) {

                sessionService.save(response.data);
                eventBus.emitEvent('UserSignedIn', {
                    accessToken: response.data.accessToken,
                    id: response.data.id,
                    username: response.data.username,
                    role: response.data.role,
                    email: response.data.email
                });

                if( response.status == 200){
                    $state.go('ideasPage');
                }

                $scope.errorCode = null;
            }

            function onError(response) {
                if (response.status && response.statusText) {
                    $scope.errorCode = response.statusText;
                } else {
                    $scope.errorCode = 'Unknown error';
                }
                $state.go('signInPage');
            }

        }

    }

})();