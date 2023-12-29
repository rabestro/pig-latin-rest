report {
    issueNamePrefix 'Issue #'
    issueUrlPrefix 'https://github.com/rabestro/pig-latin-rest/issues/'
}

spockReports {
    set(['com.athaydes.spockframework.report.showCodeBlocks'                    : true,
         'com.athaydes.spockframework.report.outputDir'                         : './target/site/spock-reports',
         'com.athaydes.spockframework.report.projectName'                       : 'Pig Latin Translator',
         'com.athaydes.spockframework.report.projectVersion'                    : 1.0,
         'com.athaydes.spockframework.report.internal.HtmlReportCreator.enabled': true,
         'com.athaydes.spockframework.report.IReportCreator'                    : 'com.athaydes.spockframework.report.internal.HtmlReportCreator'
    ])
}
