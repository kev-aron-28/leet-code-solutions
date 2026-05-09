package trees;

public class SerializeandDeserializeBinaryTree {
    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();

            serializeHelper(root, sb);

            return sb.toString();
        }



        private void serializeHelper(TreeNode root, StringBuilder sb) {
            if(root == null) {
                sb.append("N,");

                return;
            }

            sb.append(root).append(",");

            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String values[] = data.split(",");

            int index[] = { 0 };

            return deserializeHelper(values, index);
        }


        private TreeNode deserializeHelper(String[] values, int[] index) {
            String current = values[index[0]++];

            if(current.equals("N")) {
                return null;
            }

            TreeNode node = new TreeNode(Integer.parseInt(current));

            node.left = deserializeHelper(values, index);
            node.right = deserializeHelper(values, index);

            return node;
        }
    }
}
