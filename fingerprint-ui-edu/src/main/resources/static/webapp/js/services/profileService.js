/**
 * Created by lauearo on 19/06/2017.
 */
define([], function () {
    function profileService($resource) {
        var profiles = $resource("/profile/current");

        return profiles;
    }

    profileService.$inject = ['$resource'];
    return profileService;
});