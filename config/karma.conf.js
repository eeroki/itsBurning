module.exports = function(config){
    config.set({
    basePath : '../',

    files : [
      'src/main/webapp/lib/angular/angular.js',
      'src/main/webapp/lib/angular/angular-*.js',
      'src/test/webapp/lib/angular/angular-mocks.js',
      'src/main/webapp/js/**/*.js',
      'src/test/webapp/unit/**/*.js'
    ],

    exclude : [
      'src/main/webapp/lib/angular/angular-loader.js',
      'src/main/webapp/lib/angular/*.min.js',
      'src/main/webapp/lib/angular/angular-scenario.js'
    ],

    autoWatch : true,

    frameworks: ['jasmine'],

    browsers : ['Chrome'],

    plugins : [
            'karma-junit-reporter',
            'karma-chrome-launcher',
            'karma-firefox-launcher',
            'karma-jasmine'
            ],

    junitReporter : {
      outputFile: 'test_out/unit.xml',
      suite: 'unit'
    }

})}
