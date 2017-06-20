/**
 * Created by lauearo on 20/06/2017.
 */
define([], function () {
    function institutionService($resource) {
        var institution = $resource('/ins/:insId', {
            insId: '@id'
        }, {
            put:{
                method: 'PUT'
            }
        });

        return institution;
    }

    institutionService.$inject = ['$resource'];
    return institutionService;
});