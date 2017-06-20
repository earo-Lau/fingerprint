/**
 * Created by lauearo on 20/06/2017.
 */
define([], function () {
    function resourceInterceptor() {
        return {
            request: function (config) {
                console.debug("resource's request >>>>>>>>", config);
                config.headers.Authorization = 'Bearer ' + localStorage.getItem('token');
                return config;
            },
            responseError: function (error) {
                console.debug("resource get error >>>>>>>>>>>>>", error);

                switch (error.status) {
                    case 401:
                        window.location.href = '/webapp/login.html';
                        break;
                }
            }
        }
    }

    resourceInterceptor.inject = [];
    return resourceInterceptor;
})