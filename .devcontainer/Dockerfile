# [Choice] Debian OS version (use bullseye on local arm64/Apple Silicon): buster, bullseye
ARG VARIANT="buster"
FROM mcr.microsoft.com/devcontainers/java:1-8-${VARIANT}

# [Optional] Uncomment this section to install additional OS packages.
# RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
#     && apt-get -y install --no-install-recommends <your-package-list-here>

# Install Nodejs
RUN apt-get update -yq \
    && export DEBIAN_FRONTEND=noninteractive \
    && curl -L https://deb.nodesource.com/setup_14.x | bash \
    && apt-get update -yq \
    && apt-get install -yq nodejs \
    && rm -rf /var/lib/apt/lists/* \
    && npm install -g npm@latest
    
# Install Angular
RUN npm install --global @angular/cli@12
