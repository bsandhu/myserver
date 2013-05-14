/**
 * Created with IntelliJ IDEA.
 * User: baljeetsandhu
 * Date: 5/11/13
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */
//The build will inline common dependencies into this file.
//For any third party dependencies, like jQuery, place them in the lib folder.

//Configure loading modules from the lib directory,
//except for 'app' ones, which are in a sibling
//directory.
requirejs.config({
    baseUrl: 'resources/js',
    paths: {
        app: 'app'
    }
});
