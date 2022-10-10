package entity;

public class AudioData
{
    private String audioName;
    private String audioUrl;

    public AudioData(String audioName, String audioUrl) {
        this.audioName = audioName;
        this.audioUrl = audioUrl;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    @Override
    public String toString() {
        return "AudioData{" +
                "audioName='" + audioName + '\'' +
                ", audioUrl='" + audioUrl + '\'' +
                '}';
    }
}
