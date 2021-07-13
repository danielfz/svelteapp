<script lang="ts">
    import GruntListElement from "./GruntListElement.svelte";
    import {onMount} from "svelte";
    import axios from "axios";

    // callback function
    onMount(async () => {
        const response = await axios.get('/grunt');
        console.log(response);
    });
    const gruntsPromise = async function() {
        const resp = await axios.get("/grunt/");
        const body = await resp.data;
        console.log(body);
        return body;
    }();

</script>

<div id="grunt-list">
    {#await gruntsPromise}
        <p>Loading...</p>
    {:then grunts}
        <ul>
            {#each grunts as grunt}
                <li>
                    <GruntListElement grunt={grunt}/>
                </li>
            {/each}
        </ul>
    {:catch err}
        <p>There was an error</p>
    {/await}
</div>

<style>
    #grunt-list {
        background: coral;
        height: 100%;
    }

    ul {
        list-style-type: none;
        padding-left: 0;
    }

    li {
        margin-bottom: 0.5pc;
        margin-top: 0.5pc;
        border-bottom: black;
        background: cyan;
        width: 100%;
    }

</style>
