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
        .directive('createNewIdea', function() {
            return {
                restrict: 'E',
                scope: {},
                templateUrl: 'src/app/components/forms/createNewIdea.html',
                controller: 'CreateNewIdeaController'
            };
        });

    angular
        .module('webApp')
        .controller('CreateNewIdeaController', CreateNewIdeaController);

    CreateNewIdeaController.$inject = ['$scope', 'eventBus', 'ideaApi'];

    function CreateNewIdeaController($scope, eventBus, ideaApi) {

        $scope.model = {};
        $scope.errorCode = null;
        $scope.submit = submit;

        function submit(form) {
            if (form !== undefined && form.$submitted && form.$invalid) {
                return false;
            }
            ideaApi.createIdea($scope.model).then(onSuccess, onError);

            function onSuccess(response) {
                eventBus.emitEvent('IdeaUpdated');
                eventBus.emitEvent('ModalClose');
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