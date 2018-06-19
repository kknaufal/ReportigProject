
var gulp = require('gulp'),
    webserver = require('gulp-webserver'),
    del = require('del'),
    sass = require('gulp-sass'),
    karma = require('gulp-karma'),
    jshint = require('gulp-jshint'),
    sourcemaps = require('gulp-sourcemaps'),
    spritesmith = require('gulp.spritesmith'),
    browserify = require('browserify'),
    source = require('vinyl-source-stream'),
    buffer = require('vinyl-buffer'),
    uglify = require('gulp-uglify'),
    gutil = require('gulp-util'),
    ngAnnotate = require('browserify-ngannotate');

var CacheBuster = require('gulp-cachebust');
var cachebust = new CacheBuster();
var distPath = '../poreport/src/main/resources/static'

/////////////////////////////////////////////////////////////////////////////////////
//
// cleans the build output
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('clean', function (cb) {
    del([
        distPath,
        './app/js/templateCachePartials.js'
    ], {force:true});
    cb();
});

/////////////////////////////////////////////////////////////////////////////////////
//
// runs bower to install frontend dependencies
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('bower', function (done) {

    var install = require("gulp-install");

    return gulp.src(['./bower.json'], { strict: true, allowEmpty: true })
        .pipe(install());
    done();
});


/////////////////////////////////////////////////////////////////////////////////////
//
// runs sass, creates css source maps
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('build-css', function (done) {
    return gulp.src('./app/css/**/*')
        .pipe(sourcemaps.init())
        .pipe(sass())
        .pipe(cachebust.resources())
        .pipe(sourcemaps.write('./maps'))
        .pipe(gulp.dest(distPath+'/css'));
    done();
});

gulp.task('build-login-css', function (done) {
    return gulp.src('./app/login-css/**/*')
        //.pipe(sourcemaps.init())
        //.pipe(sass())
        //.pipe(cachebust.resources())
        //.pipe(sourcemaps.write('./maps'))
        .pipe(gulp.dest(distPath+'/login-css'));
    done();
});

/////////////////////////////////////////////////////////////////////////////////////
//
// fills in the Angular template cache, to prevent loading the html templates via
// separate http requests
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('build-template-cache', function (done) {

    var ngHtml2Js = require("gulp-ng-html2js"),
        concat = require("gulp-concat");

    return gulp.src("./app/partials/*.html")
        .pipe(ngHtml2Js({
            moduleName: "poPartials",
            prefix: "/partials/"
        }))
        .pipe(concat("templateCachePartials.js"))
        .pipe(gulp.dest('./app/partialDist/'));
    done();
});

/////////////////////////////////////////////////////////////////////////////////////
//
// runs jshint
//
/////////////////////////////////////////////////////////////////////////////////////
const stylish = require('jshint-stylish');
gulp.task('jshint', function (done) {
    gulp.src('./app/js/**/*.js')
        .pipe(jshint())
        .pipe(jshint.reporter(stylish));
    //.pipe(jshint.reporter('fail'));
    done();
});

/////////////////////////////////////////////////////////////////////////////////////
//
// Build a minified Javascript bundle - the order of the js files is determined
// by browserify
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('build-js', function (done) {
    var b = browserify({
        entries: './app/js/app.js',
        debug: true,
        paths: ['./app/js/**/*.js'],
        transform: [ngAnnotate]
    });

    return b.bundle()
        .pipe(source('bundle.js'))
        .pipe(buffer())
        .pipe(cachebust.resources())
        .pipe(sourcemaps.init({ loadMaps: true }))
        .pipe(uglify())
        .on('error', function (err) { gutil.log(gutil.colors.red('[Error]'), err.toString()); })
        .pipe(sourcemaps.write('./'))
        .pipe(gulp.dest(distPath+'/js/'));

    done();
});

/////////////////////////////////////////////////////////////////////////////////////
//
// copy fonts
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('fonts', function(){
    return gulp.src('node_modules/angular-ui-grid/*.+(ttf|woff)')
    .pipe(gulp.dest(distPath+'/css/'))
});

/////////////////////////////////////////////////////////////////////////////////////
//
// runs karma tests
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('test', function (done) {
    var testFiles = [
        '/test/*.js'
    ];

    return gulp.src(testFiles)
        .pipe(karma({
            configFile: 'karma.conf.js',
            action: 'run',
            singleRun: true,
            preprocessors: {
                './app/js/**/*.js': ['coverage']
            },
            reporters: ['progress', 'coverage', 'html'],
            coverageReporter: {
                type: 'html',
                dir: 'coverage-report/',
                subdir: '.'
            },
            htmlReporter: {
                outputDir: 'unit-test-report', // where to put the reports  
                templatePath: null, // set if you moved jasmine_template.html 
                focusOnFailures: true, // reports show failures on start 
                namedFiles: false, // name files instead of creating sub-directories 
                pageTitle: null, // page title for reports; browser info by default 
                urlFriendlyName: false, // simply replaces spaces with _ for files/dirs 
                reportName: 'report', // report summary filename; browser info by default 


                // experimental 
                preserveDescribeNesting: false, // folded suites stay folded  
                foldAll: false, // reports start folded (only with preserveDescribeNesting) 
            }
        }))
        .on('error', function (err) {
            console.log('karma tests failed: ' + err);
            this.emit('end');
            //throw err;
        });
    done();
});

/////////////////////////////////////////////////////////////////////////////////////
//
// generates a sprite png and the corresponding sass sprite map.
// This is not included in the recurring development build and needs to be run separately
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('sprite', function (done) {

    var spriteData = gulp.src('./app/images/*.png')
        .pipe(spritesmith({
            imgName: 'ems-sprite.png',
            cssName: '_ems-sprite.scss',
            algorithm: 'top-down',
            padding: 5
        }));

    spriteData.css.pipe(gulp.dest(distPath));
    spriteData.img.pipe(gulp.dest(distPath));
    done();
});

/////////////////////////////////////////////////////////////////////////////////////
//
// Copy all image files to dist
//
/////////////////////////////////////////////////////////////////////////////////////
gulp.task('copy-images', function (done) {
    gulp.src('./app/images/*.*')
        .pipe(gulp.dest(distPath+'/images'));
    done();

});


/////////////////////////////////////////////////////////////////////////////////////
//
// full build (except sprites), applies cache busting to the main page css and js bundles
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('build', gulp.series('clean', 'bower', 'build-css', 'build-template-cache', 'jshint', 'copy-images', 'build-js','fonts', function (done) {
    return gulp.src('./app/index.html')
        .pipe(cachebust.references())
        .pipe(gulp.dest(distPath));
    done();
}));

/////////////////////////////////////////////////////////////////////////////////////
//
// watches file system and triggers a build when a modification is detected
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('watch', function (done) {
    // return gulp.watch(['./index.html','./partials/*.html', './styles/*.*css', './js/**/*.js'], ['build']);
    gulp.watch('./app/index.html', gulp.series('build'));
    gulp.watch('./app/partials/*.html', gulp.series('build'));
    gulp.watch('./app/styles/*.*css', gulp.series('build'));
    gulp.watch('./app/js/**/*.js', gulp.series('build'));
    done();
});

/////////////////////////////////////////////////////////////////////////////////////
//
// launches a web server that serves files in the current directory
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('webserver', gulp.series('watch', function (done) {
    gulp.src('.')
        .pipe(webserver({
            livereload: false,
            directoryListing: true,
            //open: "http://localhost:8000/dist/index.html"
        }));
    done();
}));

/////////////////////////////////////////////////////////////////////////////////////
//
// launch a build upon modification and publish it to a running server
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('dev', gulp.series('webserver'));


/////////////////////////////////////////////////////////////////////////////////////
//
// installs and builds everything, including sprites
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('serve', gulp.series('sprite', 'build', 'build-login-css'/* , 'test' */));