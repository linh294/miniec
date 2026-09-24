function getApiUrl() {
    const hostname = window.location.hostname;

    // Dev: localhost hoặc 127.0.0.1
    if (hostname === "localhost" || hostname === "127.0.0.1") {
        return "http://localhost:8080";
    }

    // Prod: domain thực
    // return "https://api.production.com";
    return "https://miniec-staging.onrender.com";
}

const API_URL = getApiUrl();

console.log("API URL:", API_URL);  // Debug: xem cái gì được load
