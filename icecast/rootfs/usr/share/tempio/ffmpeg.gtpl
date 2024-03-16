#!/usr/bin/with-contenv bashio

bashio::net.wait_for 8000
echo {{ .STREAM_URL }}
ffmpeg -hide_banner -loglevel error -nostats -re -c:a libmp3lame -b:a 128k -content_type audio/mpeg -f mp3 -ice_name "{{ .STREAM_NAME }}" -ice_description {{ .STREAM_URL }}  -i {{ .STREAM_URL }} icecast://source:password@localhost:8000/{{ .MOUNTPOINT }}
