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
        .directive('resetPasswordForm', function() {
            return {
                restrict: 'E',
                scope: {
                    resetPasswordCode: '='
                },
                templateUrl: 'src/app/components/forms/resetPasswordForm.html',
                controller: 'ResetPasswordFormController'
            };
        });

    angular
        .module('webApp')
        .controller('ResetPasswordFormController', ResetPasswordFormController);

    ResetPasswordFormController.$inject = ['$scope', '$state', 'authenticationApi'];

    function ResetPasswordFormController($scope, $state, authenticationApi) {

        $scope.model = {};
        $scope.errorCode = null;
        $scope.submit = submit;

        function submit(form) {
            if (form !== undefined && form.$submitted && form.$invalid) {
                return false;
            }
            authenticationApi.resetPassword($scope.model).then(onSuccess, onError);

            function onSuccess(response) {
                $state.go('signInPage');
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