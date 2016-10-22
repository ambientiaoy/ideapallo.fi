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
        .service('addIdealistToAccountApiService', addIdealistToAccountApiService);

    addIdealistToAccountApiService.$inject = ['$http', 'sessionService'];

    function addIdealistToAccountApiService($http, sessionService) {

        var ideapalloApiUrl = '';

        return {
            init: init,
            create: create
        };

        function init(ideapalloUrl) {
            ideapalloApiUrl = ideapalloUrl;
        }

        /** create (secured)
         * request - CreateRequest {
         *   username: Optional[String]
         *   role: AccountTypes
         *   email: Optional[String]
         *   passwordHash: Optional[String]
         *   emailVerificationCode: Optional[String]
         *   emailVerificationCodeTimestamp: Optional[DateTime]
         *   emailVerified: Optional[Boolean]
         *   resetPasswordCode: Optional[String]
         *   resetPasswordCodeTimestamp: Optional[DateTime]
         *   facebookId: Optional[String]
         * }
         *
         * response - CreateResponse {
         *   id: Int
         *   username: Optional[String]
         *   role: AccountTypes
         *   email: Optional[String]
         *   passwordHash: Optional[String]
         *   emailVerificationCode: Optional[String]
         *   emailVerificationCodeTimestamp: Optional[DateTime]
         *   emailVerified: Optional[Boolean]
         *   resetPasswordCode: Optional[String]
         *   resetPasswordCodeTimestamp: Optional[DateTime]
         *   facebookId: Optional[String]
         * }
         *
         */
        function create(model) {
            return $http({
                method: 'POST',
                url: ideapalloApiUrl + '/api/create',
                data: {
                    username: model.username,
                    role: model.role,
                    email: model.email,
                    passwordHash: model.passwordHash,
                    emailVerificationCode: model.emailVerificationCode,
                    emailVerificationCodeTimestamp: model.emailVerificationCodeTimestamp,
                    emailVerified: model.emailVerified,
                    resetPasswordCode: model.resetPasswordCode,
                    resetPasswordCodeTimestamp: model.resetPasswordCodeTimestamp,
                    facebookId: model.facebookId
                },
                headers: {
                    'Authorization': "Bearer " + sessionService.getSessionData().accessToken
                }
            }).then(convertCreateResponse);
        }

        function convertCreateResponse(response) {
            response.data.emailVerificationCodeTimestamp = response.data.emailVerificationCodeTimestamp ? new Date(response.data.emailVerificationCodeTimestamp) : null;
            response.data.resetPasswordCodeTimestamp = response.data.resetPasswordCodeTimestamp ? new Date(response.data.resetPasswordCodeTimestamp) : null;
            return response;
        }
    }
})();