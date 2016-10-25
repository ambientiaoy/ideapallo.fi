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
        .directive('viewSingleIdeaModal', function() {
            return {
                restrict: 'E',
                scope: {
                    visible: '=',
                    id: '='
                },
                templateUrl: 'src/app/components/views/viewSingleIdeaModal.html',
                controller: 'ViewSingleIdeaModalController'
            };
        });

    angular
        .module('webApp')
        .controller('ViewSingleIdeaModalController', ViewSingleIdeaModalController);

    ViewSingleIdeaModalController.$inject = ['$scope', 'eventBus', 'ideaApi'];

    function ViewSingleIdeaModalController($scope, eventBus, ideaApi) {

        $scope.model = {};
        $scope.errorCode = null;
        $scope.onViewIdea = eventBus.onEvent('ViewIdea', onViewIdea);

        if ($scope.id) load($scope.id);

        function load(id) {
            var request = {
                id: id
            };
            ideaApi.readIdea(request).then(onSuccess, onError);

            function onSuccess(response) {
                $scope.model = response.data;
            }

            function onError(response) {
                if (response.status && response.statusText) {
                    $scope.errorCode = response.statusText;
                } else {
                    $scope.errorCode = 'Unknown error';
                }
            }

        }

        function onViewIdea(event, payload) {
            modalWindows.openCreateNewIdea();
            $scope.visible = true;
        }

    }
})();