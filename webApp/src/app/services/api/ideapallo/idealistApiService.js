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
        .service('idealistApiService', idealistApiService);

    idealistApiService.$inject = ['$http', 'sessionService'];

    function idealistApiService($http, sessionService) {

        var ideapalloApiUrl = '';

        return {
            init: init,
            readIdealist: readIdealist,
            createIdealist: createIdealist,
            updateIdealist: updateIdealist,
            deleteIdealist: deleteIdealist
        };

        function init(ideapalloUrl) {
            ideapalloApiUrl = ideapalloUrl;
        }

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
            return $http({
                method: 'GET',
                url: ideapalloApiUrl + '/api/idealist/' + model.id + '',
                headers: {
                    'Authorization': "Bearer " + sessionService.getSessionData().accessToken
                }
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
            return $http({
                method: 'POST',
                url: ideapalloApiUrl + '/api/idealist',
                data: {
                    accountId: model.accountId
                },
                headers: {
                    'Authorization': "Bearer " + sessionService.getSessionData().accessToken
                }
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
            return $http({
                method: 'PUT',
                url: ideapalloApiUrl + '/api/idealist/' + model.id + '',
                data: {
                    accountId: model.accountId
                },
                headers: {
                    'Authorization': "Bearer " + sessionService.getSessionData().accessToken
                }
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
            return $http({
                method: 'DELETE',
                url: ideapalloApiUrl + '/api/idealist/' + model.id + '',
                data: {
                    id: model.id
                },
                headers: {
                    'Authorization': "Bearer " + sessionService.getSessionData().accessToken
                }
            });
        }

    }
})();