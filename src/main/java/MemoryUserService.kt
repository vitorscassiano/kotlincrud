import io.vertx.core.Future

class MemoryUserService(): UserInterface {
    val _users = HashMap<String, UserModel>()

    init {
        addUser(UserModel("1", "user1_fname", "user1_lname"))
    }

    override fun getUser(id: String): Future<UserModel> {
        return if (_users.containsKey(id)) Future.succeededFuture(_users.get(id))
        else Future.failedFuture(IllegalArgumentException("Unknown user $id"))
    }

    override fun addUser(user: UserModel): Future<Unit> {
        _users.put(user.id, user)
        return Future.succeededFuture()
    }

    override fun remUser(id: String): Future<Unit> {
        _users.remove(id)
        return Future.succeededFuture()
    }
}