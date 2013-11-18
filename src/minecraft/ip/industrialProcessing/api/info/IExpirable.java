package ip.industrialProcessing.api.info;

public interface IExpirable {
    public void tick();
    public boolean isExpired();
}
