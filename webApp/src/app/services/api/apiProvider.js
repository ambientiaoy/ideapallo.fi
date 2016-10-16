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
        .provider('ideaApi', ideaApi)
        .config(ideaApiProvider);

    function ideaApi() {
        var isMocked = false;

        var $get = ['ideaApiService', 'ideaApiMockService', 'clientConfigurationValues', function(ideaApiService, ideaApiMockService, clientConfigurationValues) {
            if (this.isMocked) {
                return ideaApiMockService;
            } else {
                if (clientConfigurationValues.remoteIdeapalloUrl) {
                    ideaApiService.init(clientConfigurationValues.remoteIdeapalloUrl);
                }
                return ideaApiService;
            }
        }];

        return {
            isMocked: isMocked,
            $get: $get
        };
    }

    function ideaApiProvider(clientConfigurationValues, ideaApiProvider) {
        ideaApiProvider.isMocked = clientConfigurationValues.useServerMock;
    }

})();