package ip.industrialProcessing.api.info;

public interface IExpirable {
    public boolean tick();
    public boolean isExpired();
}
