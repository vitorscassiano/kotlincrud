import io.vertx.core.Future

interface UserInterface {
    fun getUser(id: String): Future<UserModel>
    fun addUser(user: UserModel): Future<Unit>
    fun remUser(id: String): Future<Unit>
}