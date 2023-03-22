import java.util.*;

class ServerAllocator {
    private Map<String, List<Integer>> allocatedServers = new HashMap<>();

    public String allocateServer(String region) {
        List<Integer> servers = allocatedServers.computeIfAbsent(region, k -> new ArrayList<>());
        int nextServerNumber = nextServerNumber(servers.stream().mapToInt(i->i).toArray());
        String serverName = region + nextServerNumber;
        servers.add(nextServerNumber);
        return serverName;
    }

    public void deallocateServer(String serverName) {
        String region = serverName.substring(0, serverName.length() - 1);
        int serverNumber = Integer.parseInt(serverName.substring(serverName.length() - 1));
        List<Integer> servers = allocatedServers.get(region);
        if (servers != null) {
            servers.remove((Integer) serverNumber);
        }
    }

    private static int nextServerNumber(int[] servers) {
        Arrays.sort(servers);
        int next = 1;
        for (int i = 0; i < servers.length; i++) {
            if (servers[i] == next) {
                next++;
            }
        }
        return next;
    }
}

public class Part2 {

    public static void main (String[] args) throws java.lang.Exception
    {
        ServerAllocator allocator = new ServerAllocator();
        System.out.println(allocator.allocateServer("south")); // prints "south1"
        System.out.println(allocator.allocateServer("south")); // prints "south2"
        System.out.println(allocator.allocateServer("north")); // prints "north1"
        allocator.deallocateServer("south1");
        System.out.println(allocator.allocateServer("south")); // prints "south1"
        System.out.println(allocator.allocateServer("south")); // prints "south3"


    }


}
