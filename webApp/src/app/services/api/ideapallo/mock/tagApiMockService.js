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
        .service('tagApiMockService', tagApiMockService);

    tagApiMockService.$inject = ['$timeout'];

    function tagApiMockService($timeout) {

        return {
            tags: tags
        };

        /** tags 
         * request - Unit
         *
         * response - List [
         *   TagsResponse {
         *     id: Int
         *     name: String
         *   }
         * ]
         *
         */
        function tags() {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }
    }
})();