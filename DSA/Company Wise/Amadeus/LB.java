// Load Balancer
/** Servers
A company has N servers numbered 1 to N. Inm.•y. au
the servers have O load. One by one. M requests •te
made to the companys API. The company Will weed
out the request among its servers so that the Boad iS
balanced at all times. The load iS sajd to be bonced if
the maximum load in the server iS the mun•mum
possible.
For each API request. find out the server that w" serve
the request
Notes
All requests cause a cumulative zad to me
servers which means the loads keep on adding
If two servers currentty have the same
server
load. the numerically smaller
serve the request */

import java.util.PriorityQueue;

public class LoadBalancer {

    static class Server implements Comparable<Server> {
        int load;
        int id;

        Server(int load, int id) {
            this.load = load;
            this.id = id;
        }

        @Override
        public int compareTo(Server other) {
            if (this.load != other.load) {
                return Integer.compare(this.load, other.load);
            }
            return Integer.compare(this.id, other.id);
        }
    }

    public static int[] assignRequests(int N, int M, int[] requests) {
        PriorityQueue<Server> heap = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            heap.add(new Server(0, i));
        }

        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            Server server = heap.poll();
            result[i] = server.id;
            heap.add(new Server(server.load + requests[i], server.id));
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 2;
        int M = 2;
        int[] requests = {5, 5};
        int[] result = assignRequests(N, M, requests);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }
}