<script lang="ts">
    export let grunt;
</script>

<div id="grunt-list-element">
    <p id="author">
        by <emph>{grunt.author}</emph>
    </p>
    <p id="noise">
        {grunt.noise}
    </p>
</div>
<style>
    #grunt-list-element {
        padding: 5px;
    }
</style>
