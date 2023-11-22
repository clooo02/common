package github.clooo.common;

public class FriendModel {
    private int id;
    private String username;
    private int avatarResId; // 使用整数来表示头像资源的ID

    public FriendModel(int id, String username, int avatarResId) {
        this.id = id;
        this.username = username;
        this.avatarResId = avatarResId;
    }

    // 添加 getter 方法
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getAvatarResId() {
        return avatarResId;
    }
}