client.test("Request executed successfully", function () {
    client.assert(response.status === 200, `Expected '200' but received '${response.status}'`);
});
