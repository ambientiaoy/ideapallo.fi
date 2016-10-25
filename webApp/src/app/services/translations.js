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
                IDEAS_BY_TAGS_ID: 'Id',
                IDEAS_BY_TAGS_NAME: 'Name',
                IDEAS_BY_TAGS_VIEW_IDEA: 'View idea',
                CREATE_NEW_IDEA_TAGS: "tags",
                IDEAS_CONTENT: 'Content',
                IDEAS_ID: 'Id',
                IDEAS_IDEALIST_ID: 'Idealist id',
                IDEAS_TAGS_ID: 'Tags id',
                IDEAS_TITLE: 'Title',
                IDEAS_VIEW_IDEA: 'View idea',
                IDEA_VIEW_CONTENT: 'Content',
                IDEA_VIEW_PEOPLE: 'Folks interested in the idea',
                IDEA_VIEW_ID: 'Id',
                IDEA_VIEW_TITLE: 'Title',
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
                SITE_HEADER_HAE: 'Hae',
                SITE_HEADER_KUINKA_PALVELU_TOIMII: 'Kuinka palvelu toimii',
                SITE_HEADER_OSALLISTU: 'Osallistu',
                SITE_HEADER_UUSI_IDEA: 'Uusi idea',
                TAGS_ID: 'Id',
                TAGS_NAME: 'Name',
                TAGS_VIEW_TAGS: 'View tags',
                VERIFY_EMAIL_FORM_EMAIL_VERIFICATION_CODE: 'Email verification code',
                VERIFY_EMAIL_FORM_EMAIL_VERIFICATION_CODE_IS_REQUIRED: 'Email verification code is required',
                VERIFY_EMAIL_FORM_EMAIL_VERIFICATION_CODE_MAX: 'Email verification code max',
                VERIFY_EMAIL_FORM_EMAIL_VERIFICATION_CODE_MIN: 'Email verification code min',
                VERIFY_EMAIL_FORM_SUBMIT: 'Submit',
                VIEW_IDEA_MODAL_CONTENT: 'Content',
                VIEW_IDEA_MODAL_ID: 'Id',
                VIEW_IDEA_MODAL_TITLE: 'Title',
                YES: 'Yes'
            });


            $translateProvider.translations('fi', {
                ALERT_CLOSE: 'Sulje',
                CANCEL: 'Peruuta',
                CHANGE_PASSWORD_FORM_NEW_PASSWORD: 'Uusi salasana',
                CHANGE_PASSWORD_FORM_NEW_PASSWORD_IS_REQUIRED: 'Salasana on pakollinen',
                CHANGE_PASSWORD_FORM_NEW_PASSWORD_MAX: 'Salasana on liian pitkä',
                CHANGE_PASSWORD_FORM_NEW_PASSWORD_MIN: 'Salasana on liian lyhyt',
                CHANGE_PASSWORD_FORM_NEW_PASSWORD_PATTERN: 'Salasanassa pitää olla isoja ja pieniä kirjaimia',
                CHANGE_PASSWORD_FORM_OLD_PASSWORD: 'Vanha salasana',
                CHANGE_PASSWORD_FORM_OLD_PASSWORD_IS_REQUIRED: 'Vanha salasana on pakollinen',
                CHANGE_PASSWORD_FORM_OLD_PASSWORD_MAX: 'Vanha salasana on liian pitkä',
                CHANGE_PASSWORD_FORM_OLD_PASSWORD_MIN: 'Vanha salasana on liian lyhyt',
                CHANGE_PASSWORD_FORM_OLD_PASSWORD_PATTERN: 'Vanhassa salasanassa pitää olla isoja ja pieniä kirjaimia',
                CHANGE_PASSWORD_FORM_SUBMIT: 'Lähetä',
                CREATE_NEW_IDEA: 'Luo uusi idea',
                CREATE_NEW_IDEA_CONTENT: 'Sisältö',
                CREATE_NEW_IDEA_CONTENT_IS_REQUIRED: 'Sisältö on pakollinen',
                CREATE_NEW_IDEA_CONTENT_MAX: 'Sisältö on liian pitkä',
                CREATE_NEW_IDEA_SUBMIT: 'Lähetä',
                CREATE_NEW_IDEA_TITLE: 'Otsikko',
                CREATE_NEW_IDEA_TITLE_IS_REQUIRED: 'Otsikko on pakollinen',
                CREATE_NEW_IDEA_TITLE_MAX: 'Otsikko on liian pitkä',
                DATA_SET_EMPTY_NO_DATA: 'Ei sisältöä',
                EMAIL_SIGN_IN_FORM_EMAIL: 'Email',
                EMAIL_SIGN_IN_FORM_EMAIL_IS_REQUIRED: 'Email on pakollinen',
                EMAIL_SIGN_IN_FORM_EMAIL_MAX: 'Email on liian pitkä',
                EMAIL_SIGN_IN_FORM_EMAIL_MIN: 'Email on liian lyhyt',
                EMAIL_SIGN_IN_FORM_EMAIL_PATTERN: 'Email ei ole oikein',
                EMAIL_SIGN_IN_FORM_PASSWORD: 'Salasana',
                EMAIL_SIGN_IN_FORM_PASSWORD_IS_REQUIRED: 'Salasana on pakollinen',
                EMAIL_SIGN_IN_FORM_PASSWORD_MAX: 'Salasana on liian pitkä',
                EMAIL_SIGN_IN_FORM_PASSWORD_MIN: 'Salasana on liian lyhyt',
                EMAIL_SIGN_IN_FORM_PASSWORD_PATTERN: 'Salasanassa tulee olla isoja ja pieniä kirjaimia',
                EMAIL_SIGN_IN_FORM_SUBMIT: 'Submit',
                EMAIL_SIGN_UP_FORM_EMAIL: 'Email',
                EMAIL_SIGN_UP_FORM_EMAIL_IS_REQUIRED: 'Email on pakollinen',
                EMAIL_SIGN_UP_FORM_EMAIL_MAX: 'Email on liian pitkä',
                EMAIL_SIGN_UP_FORM_EMAIL_MIN: 'Email on liian lyhyt',
                EMAIL_SIGN_UP_FORM_EMAIL_PATTERN: 'Email ei näytä oikealta',
                EMAIL_SIGN_UP_FORM_PASSWORD: 'Salasana',
                EMAIL_SIGN_UP_FORM_PASSWORD_IS_REQUIRED: 'Salasana on pakollinen',
                EMAIL_SIGN_UP_FORM_PASSWORD_MAX: 'Salasana on liian pitkä',
                EMAIL_SIGN_UP_FORM_PASSWORD_MIN: 'Salasana on liian lyhyt',
                EMAIL_SIGN_UP_FORM_PASSWORD_PATTERN: 'Salasanassa tulee olla isoja ja pieniä kirjaimia',
                EMAIL_SIGN_UP_FORM_SUBMIT: 'Lähetä',
                ERROR_MESSAGE: 'Virhe, joka tapahtui.',
                ERROR_TITLE: 'Virhe',
                FORGOT_PASSWORD_FORM_EMAIL: 'Email',
                FORGOT_PASSWORD_FORM_EMAIL_IS_REQUIRED: 'Email on pakollinen',
                FORGOT_PASSWORD_FORM_EMAIL_MAX: 'Email on liian pitkä',
                FORGOT_PASSWORD_FORM_EMAIL_MIN: 'Email on liian lyhyt',
                FORGOT_PASSWORD_FORM_EMAIL_PATTERN: 'Email ei näytä oikealta',
                FORGOT_PASSWORD_FORM_SUBMIT: 'Lähetä',
                HOME_PAGE_SEE_IDEAS: 'Näytä ideat',
                IDEAS_BY_TAGS_ID: 'Id',
                IDEAS_BY_TAGS_NAME: 'Nimi',
                IDEAS_BY_TAGS_VIEW_IDEA: 'Katso ideaa',
                CREATE_NEW_IDEA_TAGS: "Asiasanat",
                IDEAS_CONTENT: 'Sisältö',
                IDEAS_ID: 'Id',
                IDEAS_IDEALIST_ID: 'Ideoija',
                IDEAS_TAGS_ID: 'asiasanojen id',
                IDEAS_TITLE: 'Otsikko',
                IDEAS_VIEW_IDEA: 'Katso ideaa',
                IDEA_VIEW_CONTENT: 'Sisältö',
                IDEA_VIEW_PEOPLE: 'Ihmiset idean äärellä',
                IDEA_VIEW_ID: 'Id',
                IDEA_VIEW_TITLE: 'Osoite',
                MODAL_WINDOW_CLOSE: 'Sulje',
                NO: 'Ei',
                OK: 'Ok',
                RESET_PASSWORD_FORM_NEW_PASSWORD: 'Uusi salasana',
                RESET_PASSWORD_FORM_NEW_PASSWORD_IS_REQUIRED: 'Uusi salasana on pakollinen',
                RESET_PASSWORD_FORM_NEW_PASSWORD_MAX: 'Uusi salasana on liian pitkä',
                RESET_PASSWORD_FORM_NEW_PASSWORD_MIN: 'Uusi salasana on liian lyhyt',
                RESET_PASSWORD_FORM_NEW_PASSWORD_PATTERN: 'Salasanassa tulee olla isoja ja pieniä kirjaimia',
                RESET_PASSWORD_FORM_RESET_PASSWORD_CODE: 'Vaihda salasanaa - koodi',
                RESET_PASSWORD_FORM_RESET_PASSWORD_CODE_IS_REQUIRED: 'Vaihda-salasanaa -koodi on pakollinen',
                RESET_PASSWORD_FORM_RESET_PASSWORD_CODE_MAX: 'Koodi on liian pitkä',
                RESET_PASSWORD_FORM_RESET_PASSWORD_CODE_MIN: 'Koodi on liian lyhyt',
                RESET_PASSWORD_FORM_SUBMIT: 'Lähetä',
                SIGN_IN_PAGE_FORGOT_PASSWORD: 'Unohditko salasana?',
                SIGN_IN_PAGE_SIGN_UP: 'Kirjaudu uutena käyttäjänä',
                SIGN_IN_WITH_FACEBOOK: 'Kirjaudu Facebookilla',
                SIGN_UP_PAGE_SIGN_IN: 'Kirjaudu sisään',
                USERNAME_SIGN_UP_FORM_EMAIL: 'Käyttäjänimi',
                USERNAME_SIGN_UP_FORM_EMAIL_IS_REQUIRED: 'Käyttäjänimi on pakollinen',
                SITE_HEADER_HAE: 'Hae',
                SITE_HEADER_KUINKA_PALVELU_TOIMII: 'Kuinka palvelu toimii',
                SITE_HEADER_OSALLISTU: 'Osallistu',
                SITE_HEADER_UUSI_IDEA: 'Uusi idea',
                TAGS_ID: 'Id',
                TAGS_NAME: 'Nimi',
                TAGS_VIEW_TAGS: 'Katso asiasanoja',
                VERIFY_EMAIL_FORM_EMAIL_VERIFICATION_CODE: 'Sähköpostin varmistuskoodi',
                VERIFY_EMAIL_FORM_EMAIL_VERIFICATION_CODE_IS_REQUIRED: 'Sähköpostin varmistuskoodi on pakollinen',
                VERIFY_EMAIL_FORM_EMAIL_VERIFICATION_CODE_MAX: 'Sähköpostin varmistuskoodi on liian pitkä',
                VERIFY_EMAIL_FORM_EMAIL_VERIFICATION_CODE_MIN: 'Sähköpostin varmistuskoodi on liian lyhyt',
                VERIFY_EMAIL_FORM_SUBMIT: 'Lähetä',
                VIEW_IDEA_MODAL_CONTENT: 'Sisälö',
                VIEW_IDEA_MODAL_ID: 'Id',
                VIEW_IDEA_MODAL_TITLE: 'Otsikko',
                YES: 'Yes'
            })

            $translateProvider.preferredLanguage('fi');

            $translateProvider.useSanitizeValueStrategy('sanitizeParameters');
        });
})();
