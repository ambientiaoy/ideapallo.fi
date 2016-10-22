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
        .service('idealistApiMockService', idealistApiMockService);

    idealistApiMockService.$inject = ['$timeout'];

    function idealistApiMockService($timeout) {

        return {
            readIdealist: readIdealist,
            createIdealist: createIdealist,
            updateIdealist: updateIdealist,
            deleteIdealist: deleteIdealist
        };

        /** readIdealist (secured)
         * request - Unit
         *
         * response - ReadIdealistResponse {
         *   id: Int
         *   accountId: Int
         * }
         *
         */
        function readIdealist(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** createIdealist (secured)
         * request - CreateIdealistRequest {
         *   accountId: Int
         * }
         *
         * response - CreateIdealistResponse {
         *   id: Int
         *   accountId: Int
         * }
         *
         */
        function createIdealist(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** updateIdealist (secured)
         * request - RestUpdateIdealistRequest {
         *   accountId: Int
         * }
         *
         * response - UpdateIdealistResponse {
         *   id: Int
         *   accountId: Int
         * }
         *
         */
        function updateIdealist(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** deleteIdealist (secured)
         * request - DeleteIdealistRequest {
         *   id: Int
         * }
         *
         * response - Unit
         *
         */
        function deleteIdealist(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }
    }
})();