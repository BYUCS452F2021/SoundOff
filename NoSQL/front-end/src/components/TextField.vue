<template>
  <div class="text-area-container">
      <input :type="hidden ? 'password' : ''"  v-model="text" />
      <span>{{label}}</span>
  </div>
</template>

<script>
export default {
    name: 'TextField',
    props: ['value', 'label', 'hidden'],
    data() {
        return {
            text: ''
        }
    },
    watch: {
        value(val) {
            this.text = val 
        },
        text(val) {
            this.$emit('input', val)
        }
    }
}
</script>

<style>
    .text-area-container {
        border: 1.5px solid #ced4da;
        position: relative;
        padding: 2px;
        border-radius: 4px;
        width: 100%;
    }
    .text-area-container input {
        padding: 4px 8px;
        border: none;
        width: 100%;
        color: #495057
    }
    .text-area-container span {
        position: absolute;
        font-size: 12px;
        background-color: white;
        top: -12px;
        left: 12px;
        padding: 2px 4px;
        color: #495057;
    }

    .text-area-container input:focus{
        outline: none;
    }
</style>