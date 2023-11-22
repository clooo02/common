package github.clooo.common;

public class ChatModel {
    private int typeId;
    private int id;
    private String name;
    private int avatarResId; // 使用整数来表示头像资源的ID

    public ChatModel(int typeId, int id, String name, int avatarResId) {
        this.typeId = typeId;
        this.id = id;
        this.name = name;
        this.avatarResId = avatarResId;
    }

    // 添加 getter 方法
    public int getTypeId() {
        return typeId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAvatarResId() {
        return avatarResId;
    }
}