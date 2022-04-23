(() => {
  const getSuccessMessage = (entity) =>
      `Server has successfully created a token for a test ${entity}.`;

  const getErrorMessage = (entity) => `Failed to create token for a test ${
      entity}. Please make sure the Provider and service account information are properly configured in 'src/main/resources/config.properties'.`;

  const driverStatusLabel = document.getElementById('driver-token-status');
  const consumerStatusLabel = document.getElementById('consumer-token-status');


  const fetchToken = (entity, labelElement) => {
    fetch(`/token/${entity}/sample-entity-id`)
        .then(
            (response) => {
              if (response.status == 200) {
                labelElement.innerText = getSuccessMessage(entity);
                labelElement.classList.add('success-label');
                return;
              }

              labelElement.innerText = getErrorMessage(entity);
              labelElement.classList.add('error-label');
            },
            () => {
              labelElement.innerText = getErrorMessage(entity);
              labelElement.classList.add('error-label');
            });
  };

  fetchToken('driver', driverStatusLabel);
  fetchToken('consumer', consumerStatusLabel);
})();
