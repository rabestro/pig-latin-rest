function fn() {
    let env = karate.env; // get system property 'karate.env'
    karate.log('karate.env system property was:', env);
    if (!env) {
        env = 'azure';
    }
    const config = {
        env: env,
    }
    if (env === 'dev') {
        config.url = 'http://localhost:8080';
    } else if (env === 'azure') {
        config.url = 'https://piglatin.azurewebsites.net';
    }
    return config;
}
