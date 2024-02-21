client.test("Response content-type is json", function () {
    const type = response.contentType.mimeType;
    client.assert(type === "application/json", `Expected 'application/json' but received '${type}'`);
});
