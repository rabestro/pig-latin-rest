report {
    issueNamePrefix 'Issue #'
    issueUrlPrefix 'https://github.com/rabestro/pig-latin-rest/issues/'
}

// https://blog.solidsoft.pl/2022/04/05/more-compact-parameterized-tests-reporting-in-spock-2.1/

static boolean isExecutedFromIdea() {
    return System.getProperty("java.class.path").contains("idea_rt.jar")    //any more reliable way?
}
unroll {
    includeFeatureNameForIterations false
}
