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
        .directive('ideasByTags', function() {
            return {
                restrict: 'E',
                scope: {
                    name: '='
                },
                templateUrl: 'src/app/components/views/ideasByTags.html',
                controller: 'IdeasByTagsController'
            };
        });

    angular
        .module('webApp')
        .controller('IdeasByTagsController', IdeasByTagsController);

    IdeasByTagsController.$inject = ['$scope', 'eventBus', 'tagApi', 'modalWindows'];

    function IdeasByTagsController($scope, eventBus, tagApi, modalWindows) {
        $scope.model = [];
        $scope.errorCode = null;

        $scope.onClickViewIdea = onClickViewIdea;

        if ($scope.name) load($scope.name);

        function load(name) {
            var request = {
                name: name
            };
            tagApi.byName(request).then(onSuccess, onError);

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

        function onClickViewIdea(item) {
            modalWindows.openIdea(item);
            // eventBus.emitEvent('ViewIdea', {
            //     id: item.id
            // });
        }

    }
})();