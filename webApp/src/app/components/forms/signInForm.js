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
        .directive('signInForm', function() {
            return {
                restrict: 'E',
                scope: {},
                templateUrl: 'src/app/components/forms/signInForm.html',
                controller: 'SignInFormController'
            };
        });

    angular
        .module('webApp')
        .controller('SignInFormController', SignInFormController);

    SignInFormController.$inject = ['$scope', 'sessionService', 'eventBus', 'authenticationApi'];

    function SignInFormController($scope, sessionService, eventBus, authenticationApi) {

        $scope.model = {};
        $scope.errorCode = null;
        $scope.submit = submit;

        function submit(form) {
            if (form !== undefined && form.$submitted && form.$invalid) {
                return false;
            }
            authenticationApi.signIn($scope.model).then(onSuccess, onError);

            function onSuccess(response) {

                sessionService.save(response.data);
                eventBus.emitEvent('UserSignedIn', {
                    accessToken: response.data.accessToken,
                    id: response.data.id,
                    role: response.data.role,
                    username: response.data.username,
                    email: response.data.email
                });
                $scope.errorCode = null;
            }

            function onError(response) {
                if (response.status && response.statusText) {
                    $scope.errorCode = response.statusText;
                } else {
                    $scope.errorCode = 'Unknown error';
                }
            }

        }

    }

})();