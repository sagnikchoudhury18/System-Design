import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class RedisLockService {
    private ConcurrentHashMap<Long, ReentrantLock> locks = new ConcurrentHashMap<>();

    public boolean acquireLock(long meetingRoomId) {
        locks.putIfAbsent(meetingRoomId, new ReentrantLock());
        ReentrantLock lock = locks.get(meetingRoomId);
        return lock.tryLock();
    }

    public void releaseLock(long meetingRoomId) {
        ReentrantLock lock = locks.get(meetingRoomId);
        if (lock != null && lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }
}