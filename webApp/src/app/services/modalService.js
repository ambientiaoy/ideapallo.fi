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

    angular.module('webApp').factory('modalWindows', modalService);

    modalService.$inject = ['$uibModal'];

    function modalService($uibModal) {

        function openModal(input, template, size) {
            return $uibModal.open({
                template: template,
                controller: 'ModalController',
                bindToController: true,
                backdrop: "static",
                size: size,
                resolve: {
                    input: function() {
                        if (input) {
                            return input;
                        }
                        return {};
                    }
                }
            });
        }

        return {

            openCreateNewIdea: function() {
                return openModal({},
                    '<div class="modal-header">' +
                    '<button type="button" data-ng-click="close()" data-dismiss="modal" class="btn btn-link close" title="{{\'MODAL_WINDOW_CLOSE\' | translate}}">' +
                    '&times;' +
                    '</button>' +
                    '<h3 class="modal-title">{{"CREATE_NEW_IDEA" | translate}}</h3>' +
                    '</div>' +
                    '<div class="modal-body">' +
                    '<create-new-idea  ></create-new-idea>' +
                    '</div>' +
                    '<div class="modal-footer"></div>'
                );
            }

        };
    }

    angular.module('webApp').controller('ModalController', ModalController);
    ModalController.$inject = ['$scope', 'input', 'eventBus', '$uibModalInstance'];

    function ModalController($scope, input, eventBus, $uibModalInstance) {
        $scope.input = input;
        $scope.close = function() {
            $uibModalInstance.dismiss();
        };

        eventBus.onEvent('ModalClose', function() {
            $uibModalInstance.close();
        });
    }
})();