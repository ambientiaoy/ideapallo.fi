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
        .service('authenticationApiService', authenticationApiService);

    authenticationApiService.$inject = ['$http', 'sessionService'];

    function authenticationApiService($http, sessionService) {

        var ideapalloApiUrl = '';

        return {
            init: init,
            emailSignUp: emailSignUp,
            emailSignIn: emailSignIn,
            forgotPassword: forgotPassword,
            resetPassword: resetPassword,
            verifyEmail: verifyEmail,
            changePassword: changePassword,
            facebookSignIn: facebookSignIn
        };

        function init(ideapalloUrl) {
            ideapalloApiUrl = ideapalloUrl;
        }

        /** emailSignUp 
         * request - EmailSignUpRequest {
         *   email: String
         *   password: String
         * }
         *
         * response - List [
         *   EmailSignUpResponse {
         *     id: Int
         *     username: String
         *     role: AccountTypes
         *     email: Optional[String]
         *   }
         * ]
         *
         */
        function emailSignUp(model) {
            return $http({
                method: 'POST',
                url: ideapalloApiUrl + '/api/email-sign-up',
                data: {
                    username: model.username,
                    email: model.email,
                    password: model.password
                }
            });
        }

        /** emailSignIn 
         * request - EmailSignInRequest {
         *   email: String
         *   password: String
         * }
         *
         * response - EmailSignInResponse {
         *   accessToken: String
         *   id: Int
         *   username: String
         *   role: AccountTypes
         *   email: Optional[String]
         * }
         *
         */
        function emailSignIn(model) {
            return $http({
                method: 'POST',
                url: ideapalloApiUrl + '/api/email-sign-in',
                data: {
                    email: model.email,
                    password: model.password
                }
            });
        }

        /** forgotPassword 
         * request - ForgotPasswordRequest {
         *   email: String
         * }
         *
         * response - Unit
         *
         */
        function forgotPassword(model) {
            return $http({
                method: 'POST',
                url: ideapalloApiUrl + '/api/forgot-password',
                data: {
                    email: model.email
                }
            });
        }

        /** resetPassword 
         * request - ResetPasswordRequest {
         *   resetPasswordCode: String
         *   newPassword: String
         * }
         *
         * response - Unit
         *
         */
        function resetPassword(model) {
            return $http({
                method: 'POST',
                url: ideapalloApiUrl + '/api/reset-password',
                data: {
                    resetPasswordCode: model.resetPasswordCode,
                    newPassword: model.newPassword
                }
            });
        }

        /** verifyEmail 
         * request - VerifyEmailRequest {
         *   emailVerificationCode: String
         * }
         *
         * response - List [
         *   VerifyEmailResponse {
         *     id: Int
         *     username: String
         *     role: AccountTypes
         *     email: Optional[String]
         *   }
         * ]
         *
         */
        function verifyEmail(model) {
            return $http({
                method: 'POST',
                url: ideapalloApiUrl + '/api/verify-email',
                data: {
                    emailVerificationCode: model.emailVerificationCode
                }
            });
        }

        /** changePassword (secured)
         * request - ChangePasswordRequest {
         *   oldPassword: String
         *   newPassword: String
         * }
         *
         * response - List [
         *   ChangePasswordResponse {
         *     id: Int
         *     username: String
         *     role: AccountTypes
         *     email: Optional[String]
         *   }
         * ]
         *
         */
        function changePassword(model) {
            return $http({
                method: 'POST',
                url: ideapalloApiUrl + '/api/change-password',
                data: {
                    oldPassword: model.oldPassword,
                    newPassword: model.newPassword
                },
                headers: {
                    'Authorization': "Bearer " + sessionService.getSessionData().accessToken
                }
            });
        }

        /** facebookSignIn 
         * request - FacebookSignInRequest {
         *   facebookAccessToken: String
         * }
         *
         * response - FacebookSignInResponse {
         *   accessToken: String
         *   id: Int
         *   username: String
         *   role: AccountTypes
         *   email: Optional[String]
         * }
         *
         */
        function facebookSignIn(model) {
            return $http({
                method: 'POST',
                url: ideapalloApiUrl + '/api/facebook-sign-in',
                data: {
                    facebookAccessToken: model.facebookAccessToken
                }
            });
        }

    }
})();