class NetworkService(private val service: GitHubService) {
    suspend fun loadContributorsSuspend(organization: String): List<Repo>? {
        return service
            .getOrgRepos(organization)
    }
}