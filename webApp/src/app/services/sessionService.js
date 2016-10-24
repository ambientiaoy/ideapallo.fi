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
        .service('sessionService', sessionService);

    function sessionService() {

        /* jshint ignore:start */
        var publicStates = [];
        publicStates['appPage'] = true;
        publicStates['appPage.homePage'] = true;
        publicStates['ideaPage'] = true;
        publicStates['findByTagPage'] = true;
        publicStates['signInPage'] = true;
        publicStates['signUpPage'] = true;
        publicStates['verifyEmailPage'] = true;
        publicStates['forgotPasswordPage'] = true;
        publicStates['resetPasswordPage'] = true;

        var stateAccessRights = [];
        stateAccessRights['appPage.ideasPage'] = [];
        stateAccessRights['appPage.ideasPage']['ADMIN'] = true;
        stateAccessRights['appPage.ideasPage']['CLIENT'] = true;

        stateAccessRights['allTags'] = [];
        stateAccessRights['allTags']['ADMIN'] = true;
        stateAccessRights['allTags']['CLIENT'] = true;

        /* jshint ignore:end */

        return {
            save: save,
            clear: clear,
            getSessionData: getSessionData,
            isLoggedIn: isLoggedIn,
            canUserAccessState: canUserAccessState
        };

        function save(sessionData) {
            localStorage.setItem('accessToken', sessionData.accessToken);
            localStorage.setItem('id', sessionData.id);
            localStorage.setItem('username', sessionData.username);
            localStorage.setItem('role', sessionData.role);
            localStorage.setItem('email', sessionData.email);
        }

        function clear() {
            localStorage.removeItem('accessToken');
            localStorage.removeItem('id');
            localStorage.removeItem('username');
            localStorage.removeItem('role');
            localStorage.removeItem('email');
        }

        function getSessionData() {
            return {
                accessToken: localStorage.getItem('accessToken'),
                id: localStorage.getItem('id'),
                username: localStorage.getItem('username'),
                role: localStorage.getItem('role'),
                email: localStorage.getItem('email')
            };
        }

        function isLoggedIn() {
            return localStorage.getItem("accessToken") !== null;
        }

        function canUserAccessState(stateName) {
            if (publicStates[stateName]) {
                return true;
            }

            var user = getSessionData();
            if (!user) {
                return false;
            }

            return stateAccessRights[stateName][user.role];
        }

    }

})();