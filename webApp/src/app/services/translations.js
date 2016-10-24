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
        .config(function($translateProvider) {

            $translateProvider.translations('en', {
                ALERT_CLOSE: 'Close',
                CANCEL: 'Cancel',
                CHANGE_PASSWORD_FORM_NEW_PASSWORD: 'New password',
                CHANGE_PASSWORD_FORM_NEW_PASSWORD_IS_REQUIRED: 'New password is required',
                CHANGE_PASSWORD_FORM_NEW_PASSWORD_MAX: 'New password max',
                CHANGE_PASSWORD_FORM_NEW_PASSWORD_MIN: 'New password min',
                CHANGE_PASSWORD_FORM_NEW_PASSWORD_PATTERN: 'New password pattern',
                CHANGE_PASSWORD_FORM_OLD_PASSWORD: 'Old password',
                CHANGE_PASSWORD_FORM_OLD_PASSWORD_IS_REQUIRED: 'Old password is required',
                CHANGE_PASSWORD_FORM_OLD_PASSWORD_MAX: 'Old password max',
                CHANGE_PASSWORD_FORM_OLD_PASSWORD_MIN: 'Old password min',
                CHANGE_PASSWORD_FORM_OLD_PASSWORD_PATTERN: 'Old password pattern',
                CHANGE_PASSWORD_FORM_SUBMIT: 'Submit',
                CREATE_NEW_IDEA: 'Create new idea',
                CREATE_NEW_IDEA_CONTENT: 'Content',
                CREATE_NEW_IDEA_CONTENT_IS_REQUIRED: 'Content is required',
                CREATE_NEW_IDEA_CONTENT_MAX: 'Content max',
                CREATE_NEW_IDEA_SUBMIT: 'Submit',
                CREATE_NEW_IDEA_TAGS_IDS: 'Tags ids',
                CREATE_NEW_IDEA_TAGS_IDS_IS_REQUIRED: 'Tags ids is required',
                CREATE_NEW_IDEA_TITLE: 'Title',
                CREATE_NEW_IDEA_TITLE_IS_REQUIRED: 'Title is required',
                CREATE_NEW_IDEA_TITLE_MAX: 'Title max',
                DATA_SET_EMPTY_NO_DATA: 'No data',
                EMAIL_SIGN_IN_FORM_EMAIL: 'Email',
                EMAIL_SIGN_IN_FORM_EMAIL_IS_REQUIRED: 'Email is required',
                EMAIL_SIGN_IN_FORM_EMAIL_MAX: 'Email max',
                EMAIL_SIGN_IN_FORM_EMAIL_MIN: 'Email min',
                EMAIL_SIGN_IN_FORM_EMAIL_PATTERN: 'Email pattern',
                EMAIL_SIGN_IN_FORM_PASSWORD: 'Password',
                EMAIL_SIGN_IN_FORM_PASSWORD_IS_REQUIRED: 'Password is required',
                EMAIL_SIGN_IN_FORM_PASSWORD_MAX: 'Password max',
                EMAIL_SIGN_IN_FORM_PASSWORD_MIN: 'Password min',
                EMAIL_SIGN_IN_FORM_PASSWORD_PATTERN: 'Password pattern',
                EMAIL_SIGN_IN_FORM_SUBMIT: 'Submit',
                EMAIL_SIGN_UP_FORM_EMAIL: 'Email',
                EMAIL_SIGN_UP_FORM_EMAIL_IS_REQUIRED: 'Email is required',
                EMAIL_SIGN_UP_FORM_EMAIL_MAX: 'Email max',
                EMAIL_SIGN_UP_FORM_EMAIL_MIN: 'Email min',
                EMAIL_SIGN_UP_FORM_EMAIL_PATTERN: 'Email pattern',
                EMAIL_SIGN_UP_FORM_PASSWORD: 'Password',
                EMAIL_SIGN_UP_FORM_PASSWORD_IS_REQUIRED: 'Password is required',
                EMAIL_SIGN_UP_FORM_PASSWORD_MAX: 'Password max',
                EMAIL_SIGN_UP_FORM_PASSWORD_MIN: 'Password min',
                EMAIL_SIGN_UP_FORM_PASSWORD_PATTERN: 'Password pattern',
                EMAIL_SIGN_UP_FORM_SUBMIT: 'Submit',
                ERROR_MESSAGE: 'There was an error executing operation.',
                ERROR_TITLE: 'Error',
                FORGOT_PASSWORD_FORM_EMAIL: 'Email',
                FORGOT_PASSWORD_FORM_EMAIL_IS_REQUIRED: 'Email is required',
                FORGOT_PASSWORD_FORM_EMAIL_MAX: 'Email max',
                FORGOT_PASSWORD_FORM_EMAIL_MIN: 'Email min',
                FORGOT_PASSWORD_FORM_EMAIL_PATTERN: 'Email pattern',
                FORGOT_PASSWORD_FORM_SUBMIT: 'Submit',
                HOME_PAGE_SEE_IDEAS: 'See ideas',
                IDEAS_CONTENT: 'Content',
                IDEAS_ID: 'Id',
                IDEAS_IDEALIST_ID: 'Idealist id',
                IDEAS_PAGE_ADD_NOTE: 'Add note',
                IDEAS_TAGS_ID: 'Tags id',
                IDEAS_TITLE: 'Title',
                IDEA_CONTENT: 'Content',
                IDEA_ID: 'Id',
                IDEA_IDEALIST_ID: 'Idealist id',
                IDEA_TAGS_ID: 'Tags id',
                IDEA_TITLE: 'Title',
                MODAL_WINDOW_CLOSE: 'Close',
                NO: 'No',
                OK: 'Ok',
                RESET_PASSWORD_FORM_NEW_PASSWORD: 'New password',
                RESET_PASSWORD_FORM_NEW_PASSWORD_IS_REQUIRED: 'New password is required',
                RESET_PASSWORD_FORM_NEW_PASSWORD_MAX: 'New password max',
                RESET_PASSWORD_FORM_NEW_PASSWORD_MIN: 'New password min',
                RESET_PASSWORD_FORM_NEW_PASSWORD_PATTERN: 'New password pattern',
                RESET_PASSWORD_FORM_RESET_PASSWORD_CODE: 'Reset password code',
                RESET_PASSWORD_FORM_RESET_PASSWORD_CODE_IS_REQUIRED: 'Reset password code is required',
                RESET_PASSWORD_FORM_RESET_PASSWORD_CODE_MAX: 'Reset password code max',
                RESET_PASSWORD_FORM_RESET_PASSWORD_CODE_MIN: 'Reset password code min',
                RESET_PASSWORD_FORM_SUBMIT: 'Submit',
                SIGN_IN_PAGE_FORGOT_PASSWORD: 'Forgot password',
                SIGN_IN_PAGE_SIGN_UP: 'Sign up',
                SIGN_IN_WITH_FACEBOOK: 'Sign in with facebook',
                SIGN_UP_PAGE_SIGN_IN: 'Sign in',
                USERNAME_SIGN_UP_FORM_EMAIL: 'Username',
                USERNAME_SIGN_UP_FORM_EMAIL_IS_REQUIRED: 'Username is required',
                VERIFY_EMAIL_FORM_EMAIL_VERIFICATION_CODE: 'Email verification code',
                VERIFY_EMAIL_FORM_EMAIL_VERIFICATION_CODE_IS_REQUIRED: 'Email verification code is required',
                VERIFY_EMAIL_FORM_EMAIL_VERIFICATION_CODE_MAX: 'Email verification code max',
                VERIFY_EMAIL_FORM_EMAIL_VERIFICATION_CODE_MIN: 'Email verification code min',
                VERIFY_EMAIL_FORM_SUBMIT: 'Submit',
                YES: 'Yes'
            });

            $translateProvider.preferredLanguage('en');

            $translateProvider.useSanitizeValueStrategy('sanitizeParameters');
        });
})();