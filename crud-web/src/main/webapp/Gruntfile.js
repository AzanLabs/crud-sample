//grunt file add common grunt tasks
module.exports = function(grunt){
	'use strict'

	//load tasks
	grunt.loadNpmTasks('grunt-contrib-concat');
	grunt.loadNpmTasks('grunt-contrib-less');
	var config = {
		build : 'app/build',
		script : 'app/scripts',
		style : 'app/styles'
	};
	
	grunt.initConfig({
		pkg : grunt.file.readJSON('package.json'),
		concat : {
			options : {
				separator : ' '
			},
			dist : {
				src : ['app/scripts/*.js', 'app/scripts/*/*.js'],
				dest : 'app/build/scripts.js'
			}
		},
		less : {
			development : {
				files : {
					'app/build/style.css' : 'app/styles/*.less'
				}
			}
		}
	});

	//register grunt tasks
	grunt.registerTask('default',['concat','less']);

}
