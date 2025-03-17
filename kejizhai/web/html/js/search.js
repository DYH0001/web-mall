document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('searchButton').addEventListener('click', function() {
        var query = document.getElementById('searchInput').value;
        if (query) {
            window.location.href = 'search_results.html?q=' + encodeURIComponent(query);
        }
    });
});
