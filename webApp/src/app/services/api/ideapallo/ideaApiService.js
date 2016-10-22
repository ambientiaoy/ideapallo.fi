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
        .service('ideaApiService', ideaApiService);

    ideaApiService.$inject = ['$http', 'sessionService'];

    function ideaApiService($http, sessionService) {

        var ideapalloApiUrl = '';

        return {
            init: init,
            readIdea: readIdea,
            createIdea: createIdea,
            updateIdea: updateIdea,
            deleteIdea: deleteIdea,
            ideas: ideas
        };

        function init(ideapalloUrl) {
            ideapalloApiUrl = ideapalloUrl;
        }

        /** readIdea (secured)
         * request - Unit
         *
         * response - ReadIdeaResponse {
         *   id: Int
         *   title: String
         *   content: String
         * }
         *
         */
        function readIdea(model) {
            return $http({
                method: 'GET',
                url: ideapalloApiUrl + '/api/idea/' + model.id + '',
                headers: {
                    'Authorization': "Bearer " + sessionService.getSessionData().accessToken
                }
            });
        }

        /** createIdea (secured)
         * request - CreateIdeaRequest {
         *   title: String
         *   content: String
         * }
         *
         * response - CreateIdeaResponse {
         *   id: Int
         *   title: String
         *   content: String
         * }
         *
         */
        function createIdea(model) {
            return $http({
                method: 'POST',
                url: ideapalloApiUrl + '/api/idea',
                data: {
                    title: model.title,
                    content: model.content
                },
                headers: {
                    'Authorization': "Bearer " + sessionService.getSessionData().accessToken
                }
            });
        }

        /** updateIdea (secured)
         * request - RestUpdateIdeaRequest {
         *   title: String
         *   content: String
         * }
         *
         * response - UpdateIdeaResponse {
         *   id: Int
         *   title: String
         *   content: String
         * }
         *
         */
        function updateIdea(model) {
            return $http({
                method: 'PUT',
                url: ideapalloApiUrl + '/api/idea/' + model.id + '',
                data: {
                    title: model.title,
                    content: model.content
                },
                headers: {
                    'Authorization': "Bearer " + sessionService.getSessionData().accessToken
                }
            });
        }

        /** deleteIdea (secured)
         * request - DeleteIdeaRequest {
         *   id: Int
         * }
         *
         * response - Unit
         *
         */
        function deleteIdea(model) {
            return $http({
                method: 'DELETE',
                url: ideapalloApiUrl + '/api/idea/' + model.id + '',
                data: {
                    id: model.id
                },
                headers: {
                    'Authorization': "Bearer " + sessionService.getSessionData().accessToken
                }
            });
        }

        /** ideas (secured)
         * request - Unit
         *
         * response - List [
         *   IdeasResponse {
         *     id: Int
         *     title: String
         *     content: String
         *     idealistId: List[Int]
         *   }
         * ]
         *
         */
        function ideas() {
            return $http({
                method: 'GET',
                url: ideapalloApiUrl + '/api/ideas',
                headers: {
                    'Authorization': "Bearer " + sessionService.getSessionData().accessToken
                }
            });
        }

    }
})();