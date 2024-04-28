FROM node:20 AS appointment_system_frontend_builder
WORKDIR /app/frontend

COPY package*.json ./
RUN npm install
RUN npm install -g next

COPY next.config.mjs jsconfig.json ./
COPY src ./src
COPY public ./public

EXPOSE 3000

CMD ["npm", "run", "dev"]