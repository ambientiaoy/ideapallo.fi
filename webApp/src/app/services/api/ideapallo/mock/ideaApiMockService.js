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
        .service('ideaApiMockService', ideaApiMockService);

    ideaApiMockService.$inject = ['$timeout'];

    function ideaApiMockService($timeout) {

        return {
            readIdea: readIdea,
            createIdea: createIdea,
            updateIdea: updateIdea,
            deleteIdea: deleteIdea,
            ideas: ideas
        };

        /** readIdea 
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
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** createIdea 
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
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** updateIdea 
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
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** deleteIdea 
         * request - DeleteIdeaRequest {
         *   id: Int
         * }
         *
         * response - Unit
         *
         */
        function deleteIdea(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** ideas 
         * request - Unit
         *
         * response - List [
         *   IdeasResponse {
         *     id: Int
         *     title: String
         *     content: String
         *   }
         * ]
         *
         */
        function ideas() {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }
    }
})();