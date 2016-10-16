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
        .service('authenticationApiMockService', authenticationApiMockService);

    authenticationApiMockService.$inject = ['$timeout'];

    function authenticationApiMockService($timeout) {

        return {
            signUp: signUp,
            signIn: signIn,
            emailSignUp: emailSignUp,
            emailSignIn: emailSignIn,
            forgotPassword: forgotPassword,
            resetPassword: resetPassword,
            verifyEmail: verifyEmail,
            changePassword: changePassword,
            facebookSignIn: facebookSignIn
        };

        /** signUp 
         * request - SignUpRequest {
         *   username: String
         *   password: String
         * }
         *
         * response - List [
         *   SignUpResponse {
         *     id: Int
         *     role: AccountTypes
         *     username: Optional[String]
         *     email: Optional[String]
         *   }
         * ]
         *
         */
        function signUp(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** signIn 
         * request - SignInRequest {
         *   username: String
         *   password: String
         * }
         *
         * response - SignInResponse {
         *   accessToken: String
         *   id: Int
         *   role: AccountTypes
         *   username: Optional[String]
         *   email: Optional[String]
         * }
         *
         */
        function signIn(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** emailSignUp 
         * request - EmailSignUpRequest {
         *   password: String
         *   email: String
         * }
         *
         * response - List [
         *   EmailSignUpResponse {
         *     id: Int
         *     role: AccountTypes
         *     username: Optional[String]
         *     email: Optional[String]
         *   }
         * ]
         *
         */
        function emailSignUp(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
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
         *   role: AccountTypes
         *   username: Optional[String]
         *   email: Optional[String]
         * }
         *
         */
        function emailSignIn(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
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
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
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
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
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
         *     role: AccountTypes
         *     username: Optional[String]
         *     email: Optional[String]
         *   }
         * ]
         *
         */
        function verifyEmail(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
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
         *     role: AccountTypes
         *     username: Optional[String]
         *     email: Optional[String]
         *   }
         * ]
         *
         */
        function changePassword(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
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
         *   role: AccountTypes
         *   username: Optional[String]
         *   email: Optional[String]
         * }
         *
         */
        function facebookSignIn(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }
    }
})();