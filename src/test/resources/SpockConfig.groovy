report {
    issueNamePrefix 'Issue #'
    issueUrlPrefix 'https://github.com/rabestro/pig-latin-rest/issues/'
}
unroll {
    includeFeatureNameForIterations false
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

// https://blog.solidsoft.pl/2022/04/05/more-compact-parameterized-tests-reporting-in-spock-2.1/

static boolean isExecutedFromIdea() {
    return System.getProperty("java.class.path").contains("idea_rt.jar")    //any more reliable way?
}
